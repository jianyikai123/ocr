package blog.csdn.net.dr_guo;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
/**
 * 验证码识别（图片名即为验证码数字）
 * @author drguo
 *
 */
public class VCR {
	private final static String datapath = "src/main/resources";
	public static void main(String[] args) {
		File root = new File(System.getProperty("user.dir") + "/target/classes/imgs");
		System.out.println(System.getProperty("user.dir"));
		ITesseract instance = new Tesseract();
		instance.setDatapath(new File(datapath).getPath());

		try {
			File[] files = root.listFiles();
			for (File file : files) {
				String result = instance.doOCR(file);
				String fileName = file.toString().substring(file.toString().lastIndexOf("\\")+1);
				System.out.println("图片名：" + fileName +" 识别结果："+result);
			}
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
    }
}