package no2.Decorator;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class Body implements IPacketCreator{
    @Override
    public String print() {
        return "body";
    }
}
