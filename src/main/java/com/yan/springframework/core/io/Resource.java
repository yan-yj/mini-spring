package com.yan.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @description:
 * @author: yan-yj
 * @time: 2021/12/11 21:09
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
