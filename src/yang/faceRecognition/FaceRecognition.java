package yang.faceRecognition;

/**
 * 人脸识别相关函数。
 *
 * @author 赵阳
 * @version 2.1
 */
public class FaceRecognition
{
	private FaceRecognition()
	{
	}

	/**
	 * 加载相关动态链接库DLL文件, 加载顺序非常重要。
	 */
	static
	{
		System.loadLibrary("pthreadVC2");
		System.loadLibrary("libgcc_s_sjlj-1");
		System.loadLibrary("libquadmath-0");
		System.loadLibrary("libgfortran-3");
		System.loadLibrary("libopenblas");

		System.loadLibrary("opencv_ffmpeg2413_64");
		System.loadLibrary("opencv_core2413");
		System.loadLibrary("opencv_highgui2413");
		System.loadLibrary("opencv_imgproc2413");

		System.loadLibrary("opencv_core2413d");
		System.loadLibrary("opencv_highgui2413d");
		System.loadLibrary("opencv_imgproc2413d");

		System.loadLibrary("FaceMatcherDll");
		System.loadLibrary("FaceRecognition");
	}

	/**
	 * 调用动态链接库DLL文件，计算两张照片人脸相似度得分。
	 *
	 * @param feature1 第一个特征数组
	 * @param feature2 第二个特征数组
	 * @return 两张照片人脸相似度，值域 (0,1)
	 */
	public native static final float faceVerify(float[] feature1, float[] feature2);
}