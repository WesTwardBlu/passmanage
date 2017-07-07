package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.passmanage.vo.PassinfoVo;

public class JacksonTest {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException {
		PassinfoVo passinfoVo= new PassinfoVo();
		passinfoVo.setAccount("andi");
		passinfoVo.setPassword("0000");
		
		PassinfoVo passinfoVo2= new PassinfoVo();
		passinfoVo2.setAccount("bob");
		passinfoVo2.setPassword("1111");
		
		List<PassinfoVo> passinfoVos= new ArrayList<>();
		passinfoVos.add(passinfoVo);
		passinfoVos.add(passinfoVo2);
		System.out.println(new ObjectMapper().writeValueAsString(passinfoVos));
	}

}
