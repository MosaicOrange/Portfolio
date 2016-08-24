package com.mosaicorange.apicode;

/**
 * @author João Miguel Pinto
 * Email: mosaicorange@outlook.com
 * GitHub: https://github.com/MosaicOrange/Portfolio
 * LinkedIn: https://www.linkedin.com/in/mosaicorange
 *
 * Please feel free to reach out if you have any questions
*/

import com.sun.jersey.api.core.PackagesResourceConfig;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("/")
public class APICode extends PackagesResourceConfig {
 
    public APICode() {
        super("com.mosaicorange.apicode.res.impl");
    }
}