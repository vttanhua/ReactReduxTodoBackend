package hello;

import hello.repository.UserRepository;
import jdk.internal.jline.internal.TestAccessible;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void phase2_TestUpdateUser(){
        log.info("Testing update!");
        User u = userService.getUserById(1L);
        u.setPassword("yetAnotherPwd");
        userService.createOrUpdateUser(u);
    }

    @Test
    public void phase1_TestCreateUser() throws Exception{
        log.info("Tesing create and update!");
        User u = new User();
        u.setFirstName("Vesa");

        u.setLastName("T-T");
        u.setUserName("vttanhua");
        u.setPassword("pwd");
        User u2 = userService.createOrUpdateUser(u);
        u2.setPassword("newPassword");
        TimeUnit.SECONDS.sleep(20);
        userService.createOrUpdateUser(u2);
    }


}
