package yang.faceRecognition;

import yang.faceRecognition.dataModels.ResultModel;

import java.io.Closeable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Yang Zhao on 2017/4/23.
 *
 * @author Yang Zhao
 * @version 3.1
 */
public class DatabaseConnection implements Closeable
{
	private final Connection connection;

	public DatabaseConnection(final String host, final int port) throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:crate://" + host + ':' + port + '/');
	}

	public ArrayList<ResultModel> search(final float[] features, float threshold)
	{
		ArrayList<ResultModel> results = new ArrayList<ResultModel>(5);
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("select * from test_table limit 2147483630"))//where pk = '" + primarKey + "')
		{
			while (resultSet.next())
			{
				final Array array = resultSet.getArray("eigenvalues");
				final Float[] floats = (Float[]) array.getArray();
				final float[] currentFeatures = this.toPrimitive(floats);
				final float similarly = FaceRecognition.faceVerify(features, currentFeatures);
				if (similarly > threshold)
				{
					results.add(new ResultModel(resultSet.getString("pk"), currentFeatures, similarly));
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return results;
	}

	private static float[] toPrimitive(Float[] floats)
	{
		float[] result = new float[floats.length];
		for (int i = 0; i < floats.length; i++)
		{
			result[i] = floats[i].floatValue();
		}
		return result;
	}

	@Override
	public void close()
	{
		try
		{
			if (!connection.isClosed())
			{
				connection.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}