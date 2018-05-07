/**
 * 
 */
package one.show.mapper;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.ser.ToStringSerializer;

/**
 * @author Haliaeetus leucocephalus 2018年3月15日 下午4:37:13
 *
 */
public class JsonMapper extends ObjectMapper {
	
	public JsonMapper(){
		super();  
        // 允许单引号  
//        this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);  
        // 字段和值都加引号  
//        this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);  
        // 数字也加引号  
//        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);  
//        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true); 
		
		//long转string
		SimpleModule simpleModule=new SimpleModule("simpleModule", new Version(0,0,1,null));  
	    simpleModule.addSerializer(Long.class, new ToStringSerializer());
	    simpleModule.addSerializer(Long.TYPE, new ToStringSerializer());
	    this.registerModule(simpleModule);
		// 空值处理为空串  
		StdSerializerProvider sp = (StdSerializerProvider) this.getSerializerProvider();
        sp.setNullValueSerializer(new JsonSerializer<Object>(){

            @Override
            public void serialize(Object value, JsonGenerator jg,
                    SerializerProvider sp) throws IOException,
                    JsonProcessingException {
                 jg.writeString("");  
            }
             
        });
        
        
        
   
	}
	
}


