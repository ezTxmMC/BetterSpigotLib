package eu.moonwriters.betterspigotlib.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public class BetterComponent {
    private final Component component;

    public BetterComponent() {
        this.component = Component.empty();
    }

    public BetterComponent append(String string) {
        component.append(Component.text(string));
        return this;
    }

    public BetterComponent append(String string, TextColor color) {
        component.append(Component.text(string, color));
        return this;
    }

    public BetterComponent append(String string, NamedTextColor color) {
        component.append(Component.text(string, color));
        return this;
    }

    public void hover(String string, String hoverString) {
        component.hoverEvent(HoverEvent.showText(Component.text(hoverString)).value());
    }

    public void click(ClickEvent.Action action, String value) {
        component.clickEvent(ClickEvent.clickEvent(action, value));
    }

    public Component asComponent() {
        return component;
    }
}
