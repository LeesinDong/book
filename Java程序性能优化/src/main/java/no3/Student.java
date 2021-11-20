package no3;

import com.google.common.base.Stopwatch;
import lombok.Setter;
import org.junit.Test;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author Leesin Dong
 * @since 2021/11/20
 */

@Setter
public class Student implements Cloneable{
    private Vector v;

    public Student() throws InterruptedException {
        Thread.sleep(3000);
    }

    public Student getInstance() throws CloneNotSupportedException {
        return (Student) this.clone();
    }

    @Test
    public void test() throws InterruptedException, CloneNotSupportedException {
        Stopwatch started = Stopwatch.createStarted();
        Student student = new Student();
        student.setV(new Vector());
        Student student1 = student.getInstance();
        System.out.println(student == student1);
        System.out.println(student.v == student1.v);
        // 3005635834
        // long l = started.stop().elapsed().toNanos();
        // 3002045167
        long l1 = started.stop().elapsed(TimeUnit.NANOSECONDS);
        // System.out.println(l);
        System.out.println(l1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        Vector<Object> objects = new Vector<>();
        objects.addAll(student.v);
        student.setV(objects);
        return student;
    }
}
