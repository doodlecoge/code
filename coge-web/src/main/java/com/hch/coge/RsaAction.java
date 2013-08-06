package com.hch.coge;

import com.hch.coge.form.RsaKeysForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import java.security.*;

/**
 * Created with IntelliJ IDEA.
 * User: huaiwang
 * Date: 8/6/13
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/rsa")
public class RsaAction {
    private static String privateKeyString;
    private static String publicKeyString;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
       return "rsa";
    }

    @RequestMapping(value = "/gen", method = RequestMethod.GET)
    public String gen(ModelMap map) throws NoSuchAlgorithmException {
        KeyPair keyPair = RsaUtils.generateRsaKeyPair();

        privateKeyString = RsaUtils.b64EncodePrivateKey(keyPair.getPrivate());
        publicKeyString = RsaUtils.b64EncodePublicKey(keyPair.getPublic());


        map.addAttribute("privateKey", privateKeyString);
        map.addAttribute("publicKey", publicKeyString);

        return "rsa";
    }

    @RequestMapping(value = "/encrypt", method = RequestMethod.POST)
    public String encrypt(@RequestParam("rawData") String rawData) {
        return "";
    }

}
