# FaceRecognition

人脸识别项目。

作者：赵阳
日期：2017年4月30日

请直接调用 FaceRecognition.faceVerify(arr1, arr2) 函数。其他函数可能会在未来发行版被修改。

  /**
	 * 调用动态链接库DLL文件，计算两张照片人脸相似度得分。
	 *
	 * @param feature1 第一个特征数组
	 * @param feature2 第二个特征数组
	 * @return 两张照片人脸相似度，值域 (0,1)
	 */
	public native static final float faceVerify(float[] feature1, float[] feature2);
