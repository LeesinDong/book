package no87;

import java.io.*;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/3 4:56 下午
 */
public class StringList implements Serializable {

    private static final long serialVersionUID = -1770488332543652657L;

    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry {
        private String data;
        private Entry next;
        private Entry pre;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Entry(String data, Entry next, Entry pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }

    @Override
    public String toString() {
        return "StringList{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }

    // 1 创建ObjectOutputStream 2 调用ObjectOutputStream的writeObject
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);
        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // int elementSize = s.readInt();
        size = s.readInt();
        for (int i = 0; i < size; i++) {
            // add((String)s.readObject());
            Entry entry = new Entry("", null, null);
            entry.setData((String) s.readObject());
            head = entry;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StringList s = new StringList();
        s.head = new Entry("a", new Entry("b", null, null), new Entry("c", null, null));
        s.size = 1;

        // 序列化
        FileOutputStream stringList = new FileOutputStream("stringList");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stringList);
        objectOutputStream.writeObject(s);

        // 反序列化
        FileInputStream stringList1 = new FileInputStream("stringList");
        ObjectInputStream objectInputStream = new ObjectInputStream(stringList1);
        StringList read = (StringList) objectInputStream.readObject();
        System.out.println(read);
    }
}
