package Yinong.AlexSolution;

import Yinong.AlexSolution.Controller.UserController;
import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.UserRepository;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional


@WebAppConfiguration
public class RestfulAPITest{

    //protected Log logger= LogFactory.getLog(TestBase.class);

    @Resource
    private MockServletContext mockServletContext;

    @Resource
    private UserRepository userRepository;


    private MockMvc mvc;



    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request = null;
        userRepository.save(new User("YinongXia", "summer1993"));

        // 1、get查一下user列表，应该为空
        request = get("/home/user").content("YinongXia");
        System.out.println(mvc.perform(request).andReturn().getAsyncResult());
        System.out.println("passed");
        userRepository.deleteAll();
        // 2、post提交一个user

        User user = new User("nazisang", "summer1993");
        Gson gson = new Gson();
        request = post("/home/user/").
                accept(MediaType.APPLICATION_JSON).
                contentType(MediaType.APPLICATION_JSON_UTF8).
                content(gson.toJson(user));
        mvc.perform(request);
        //MvcResult result = mvc.perform(request).andReturn();
        //System.out.println(result.getResponse().getContentAsString());


//        // 3、get获取user列表，应该有刚才插入的数据
//        request = get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
//
//        // 4、put修改id为1的user
//        request = put("/users/1")
//                .param("name", "测试终极大师")
//                .param("age", "30");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));
//
//        // 5、get一个id为1的user
//        request = get("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
//
//        // 6、del删除id为1的user
//        request = delete("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));
//
//        // 7、get查一下user列表，应该为空
//        request = get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[]")));

    }

}
