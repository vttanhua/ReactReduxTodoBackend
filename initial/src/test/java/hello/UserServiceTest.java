package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.service.UserService;
import hello.entity.User;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void phase1_TestCreateUser() throws Exception{
        log.info("Tesing create and update!");
        User u = new User();
        u.setFirstName("Vesa");

        u.setLastName("T-T");
        u.setUsername("vttanhua");
        u.setPassword("pwd");
        User u2 = userService.createOrUpdate(u);
        u2.setPassword("newPassword");
        TimeUnit.SECONDS.sleep(1);
        userService.createOrUpdate(u2);
    }

    @Test
    public void phase2_TestUpdateUser(){
        log.info("Testing update!");
        User u = userService.getById(1L);
        u.setPassword("yetAnotherPwd");
        userService.createOrUpdate(u);
    }



    @Test
    public void phase3_TestGetUserByUserNameAndPassword(){
        User u = userService.Authenticate("vttanhua", "yetAnotherPwd");
        assertThat(u.getUsername(),is("vttanhua"));
        assertThat(u.getPassword(),is("yetAnotherPwd"));
    }


    @Test
    public void phase4_TestGetUserByUserNameAndPasswordNotFound(){
        User u = null;
        try {
            u = userService.Authenticate("vttanhuaX", "yetAnotherPwd");
            assertNull(u);
        }
        catch(IllegalArgumentException e){
            log.error(e.getMessage());
        }
        finally{

        }
    }

}
