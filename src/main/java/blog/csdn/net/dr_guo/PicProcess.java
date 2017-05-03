package blog.csdn.net.dr_guo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class PicProcess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String picPath=clearInValid(System.getProperty("user.dir")+"/img1/vci.jpg");
		System.out.println("OK");
	}
	static int range=3;//���ַ�Χ
	static int rangeValue=1;//���ַ�Χֵ
	public static String clearInValid(String picPath){
		  String newPicPath=picPath.replaceAll(".jpg","clear.jpg");
		  try{
			  List jNoRepeateList=new ArrayList(),iNoRepeateList=new ArrayList();
			  BufferedImage bufferdImage=ImageIO.read(new File(picPath));//��ImageIO�ľ�̬������ȡͼ��
			  BufferedImage newBufferdImage=ImageIO.read(new File(picPath));
			  
			  int height = bufferdImage.getHeight();
		      int width = bufferdImage.getWidth();
		      int jrange=range,irange=range,lasti=-1;
		      //BufferedImage newBufferdImage=new java.awt.image.BufferedImage(width,height,java.awt.image.BufferedImage.TYPE_INT_RGB);
		      
		      System.out.println("width:"+width+" height:"+height);
		      int rgbvalue=-1;//ȡ�õ�����ֵ
		      int lastRgbValue=-1;//�ϴε�����ֵ
		        for(int i=0;i<width;i++){
		            for(int j=0;j<height;j++){
		            	rgbvalue= bufferdImage.getRGB(i,j);
		            	System.out.println("i="+i+" j="+j+" rgbvalue="+rgbvalue);
		            	//j����ʼ
		            	if(jrange<=0){
		            		if(!isValidRange(jNoRepeateList,rangeValue)&&Math.abs(rgbvalue-lastRgbValue)<2){
		            			newBufferdImage.setRGB(i,j,-1);//��Ϊ��ɫ
		            		}
		            		jrange=range;
		            		jNoRepeateList.clear();
		            		lastRgbValue=rgbvalue;
		            	}
		            	jrange--;
		                if(!jNoRepeateList.contains(rgbvalue)){
		                	jNoRepeateList.add(rgbvalue);
		                }
		                //j�������
		            }
		            
		        }
		        
		        ImageIO.write(newBufferdImage, "JPEG", new java.io.File(newPicPath));//ȥ����ͼƬ
		        //System.out.println("all Size:"+width*height+"  noRepeateSize:"+jNoRepeateList.size());
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		return newPicPath;
	}
	private static boolean isValidRange(List list,int rangeValue){
		boolean reValue=false;
		int curValue=-1,mixValue=-1,maxValue=-1;
		for(Object obj:list){
			curValue=Integer.valueOf(obj.toString());
			if(curValue<mixValue||mixValue==-1){
				mixValue=curValue;
			}
			if(curValue>maxValue||maxValue==-1){
				maxValue=curValue;
			}	
		}
		if((maxValue-mixValue)<rangeValue){
			reValue=true;
		}
		return reValue;
	}
}
