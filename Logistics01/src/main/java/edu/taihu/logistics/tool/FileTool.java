package edu.taihu.logistics.tool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.FieldsDocumentPart;
import org.apache.poi.hwpf.usermodel.Field;
import org.apache.poi.hwpf.usermodel.Fields;
import org.apache.poi.hwpf.usermodel.Range;

import edu.taihu.logistics.pojo.Contract;

public class FileTool {
	public static File getContract(Contract contract) throws IOException {
		File file=new File("D:/oxygen/Logistics01/src/main/webapp/staticfile/contract.doc");
		File copyFile=new File("D:/oxygen/Logistics01/src/main/webapp/staticfile/contract"+contract.getOrderId().toString()+".doc");
		if(file.exists()) {
			Files.copy(file.toPath(),copyFile.toPath());
		}
		return copyFile;
	}

	public void writeDoc(File file,Map<String, String> map) {
		try {
			//读取word模板
			FileInputStream in = new FileInputStream(new File(file.getAbsolutePath()));
			HWPFDocument hdt = new HWPFDocument(in);
			Fields fields = hdt.getFields();
			Iterator<Field> it = fields.getFields(FieldsDocumentPart.MAIN).iterator();
			while(it.hasNext()){
				System.out.println(it.next().getType());
			}
			
			//读取word文本内容
			Range range = hdt.getRange();
			System.out.println(range.text());
			//替换文本内容
			for (Map.Entry<String,String> entry:map.entrySet()) {
				range.replaceText(entry.getKey(),entry.getValue());
			}    
			ByteArrayOutputStream ostream = new ByteArrayOutputStream();
			String fileName = ""+System.currentTimeMillis();
			fileName += ".doc";
			FileOutputStream out = new FileOutputStream(fileName,true);
			hdt.write(ostream);
            //输出字节流
			out.write(ostream.toByteArray());
			out.close();
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
