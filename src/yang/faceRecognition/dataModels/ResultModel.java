package yang.faceRecognition.dataModels;

/**
 * Created by Yang Zhao on 2017/4/27.
 *
 * @author Yang Zhao (D068920)
 * @version 1.3
 */
public class ResultModel
{
	private final String primaryKey;

	private final float[] features;

	private final float similarly;

	public ResultModel(String primaryKey, float[] features, float similarly)
	{
		this.primaryKey = primaryKey;
		this.features = features;
		this.similarly = similarly;
	}

	public String getPrimaryKey()
	{
		return primaryKey;
	}

	public float[] getFeatures()
	{
		return features;
	}

	public float getSimilarly()
	{
		return similarly;
	}

	@Override
	public String toString()
	{
		return String.format("Name: %1$s  Similarly: %2$f", new Object[]{primaryKey, similarly});
	}
}
