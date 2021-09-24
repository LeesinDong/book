package com.leesin.chapter10.replaceExceptionWithTest;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 12:52 下午
 */
public class ResourcePool {
    Stack _available = null;
    Stack _allocated = null;

    Resource getResourceOriginal() {
        Resource result;

        try {
            result = (Resource) _available.pop();
            _allocated.push(result);
            return result;
        } catch (EmptyStackException e) {
            result = new Resource();
            _allocated.push(result);
            return result;
        }
    }

    /**
     * 「可用资源用尽」并不是一种意料外的事件，因此我不该使用异常 （exceptions）表示这种情况
     * 不应该用 异常 来代替 条件检查
     * TODO  把Try catch变成if判断
     **/
    Resource getResource() {
        Resource result;
        if (_available.isEmpty()) {
            result = new Resource();
            _allocated.push(result);
            return result;
        } else {
            result = (Resource) _available.pop();
            _allocated.push(result);
            return result;
        }
    }
}
