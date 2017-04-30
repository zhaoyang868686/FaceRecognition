# FaceRecognition

人脸识别项目。</br>

作者：赵阳</br>
日期：2017年4月30日</br>

请将DLL文件夹和Models文件夹放到FaceRecognition根目录下。</br>
请直接调用 FaceRecognition.faceVerify(arr1, arr2) 函数。其他函数可能会在未来发行版被修改。</br>

public native static final float faceVerify(float[] feature1, float[] feature2);</br>
该函数调用动态链接库DLL文件，计算两张照片人脸相似度得分。</br>
参数 feature1 第一个特征数组;</br>
参数 feature2 第二个特征数组;</br>
返回值 两张照片人脸相似度，值域 (0,1);
