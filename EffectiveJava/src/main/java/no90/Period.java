package no90;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/3 8:49 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Period implements Serializable {

    private Date start;
    private Date end;


    private Object writeReplace() {
        return new SerializableProxy(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("");
    }

    private static class SerializableProxy implements Serializable{

        private final Date start;
        private final Date end;

        SerializableProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        private Object readResolve() throws ObjectStreamException {
            return new Period(start, end);
        }
    }

    @SneakyThrows
    public static void main(String[] args) throws IOException {
        FileOutputStream period = new FileOutputStream("Period");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(period);
        objectOutputStream.writeObject(new SerializableProxy(new Period(new Date(1, 2, 3),
                new Date(2, 3, 4))));

        FileInputStream period1 = new FileInputStream("Period");
        ObjectInputStream objectInputStream = new ObjectInputStream(period1);
        // 访问的是代理的readObject, readObject应该是走了readResolve方法，返回了Period
        Period period2 = (Period) objectInputStream.readObject();

        System.out.println(period2);
    }
}
