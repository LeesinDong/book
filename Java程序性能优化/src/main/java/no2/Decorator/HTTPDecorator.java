package no2.Decorator;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class HTTPDecorator extends AbstractDecorator {
    public HTTPDecorator(IPacketCreator iPacketCreator) {
        super(iPacketCreator);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("http start");
        sb.append(this.iPacketCreator.print());
        sb.append("http end");
        return sb.toString();
    }
}
