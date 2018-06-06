package serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 2018/6/5
 * sunshine
 */
public class User implements Serializable {

    private Long id ;

    private String name ;

    /**
     * 瞬时变量不进行序列化
     */
    private transient int age ;

    /**
     * 静态变量不进行序列化
     */
    public static int num  = 5;


    /**
     * 通过实现writeObject与readObject实现瞬态变量序列化
     * @param objectOutputStream
     * @throws IOException
     */
    private void  writeObject(ObjectOutputStream objectOutputStream)throws IOException{
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(age);
    }
    private void readObject(ObjectInputStream objectInputStream)throws Exception{
        objectInputStream.defaultReadObject();
        age = (int) objectInputStream.readObject();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
