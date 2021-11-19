package no2.Decorator;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class HTMLDecorator extends AbstractDecorator{
    public HTMLDecorator(IPacketCreator iPacketCreator) {
        super(iPacketCreator);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTML start");
        sb.append(this.iPacketCreator.print());
        sb.append("HTML end");
        return sb.toString();
    }
}
