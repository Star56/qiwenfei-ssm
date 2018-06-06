package serializable;

/**
 * 2018/6/5
 * sunshine
 */
public class AppTest {

    public static void main(String[] args) {
        ISerializable iSerializable = new XmlSerializable();
        User  user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setAge(19);
        User.num = 10;
        try {
           byte[] bytes  = iSerializable.doserialize(user);
            System.out.println(new String(bytes));
            System.out.println(iSerializable.deserialize(bytes,User.class));
            System.out.println(User.num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
