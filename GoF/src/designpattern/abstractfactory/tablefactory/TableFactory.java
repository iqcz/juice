package designpattern.abstractfactory.tablefactory;
import designpattern.abstractfactory.factory.Factory;
import designpattern.abstractfactory.factory.Link;
import designpattern.abstractfactory.factory.Page;
import designpattern.abstractfactory.factory.Tray;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
