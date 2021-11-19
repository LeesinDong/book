package no2.Decorator;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public abstract class AbstractDecorator implements IPacketCreator{
    IPacketCreator iPacketCreator;

    public AbstractDecorator(IPacketCreator iPacketCreator) {
        this.iPacketCreator = iPacketCreator;
    }
}
