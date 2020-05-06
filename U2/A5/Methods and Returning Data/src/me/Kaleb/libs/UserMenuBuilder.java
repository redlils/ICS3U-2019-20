package me.Kaleb.libs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A builder for creating a {@link me.Kaleb.libs.UserMenu}
 */
public class UserMenuBuilder {
  
  /**
   * The title of the built {@link me.Kaleb.libs.UserMenu}
   */
  String title;
  /**
   * The prompt of the built {@link me.Kaleb.libs.UserMenu}
   */
  String prompt;
  /**
   * The options of the built {@link me.Kaleb.libs.UserMenu}
   */
  List<String> options = new ArrayList<>();
  
  /**
   * Empty constructor to allow for creating a builder which will set the title of the built {@link me.Kaleb.libs.UserMenu} later
   */
  public UserMenuBuilder() {
  
  }
  
  /**
   * Constructor to start building a {@link me.Kaleb.libs.UserMenu}
   *
   * @param title The title of the resulting {@link me.Kaleb.libs.UserMenu}
   */
  public UserMenuBuilder(String title) {
    this.title = title;
  }
  
  /**
   * Sets the title of the built {@link me.Kaleb.libs.UserMenu}
   *
   * @param title The title for the built {@link me.Kaleb.libs.UserMenu}
   * @return The current builder with the title parameter changed
   */
  public UserMenuBuilder setTitle(String title) {
    this.title = title;
    return this;
  }
  
  /**
   * Sets the title of the built {@link me.Kaleb.libs.UserMenu}
   *
   * @param prompt The description for the built {@link me.Kaleb.libs.UserMenu}
   * @return The current builder with the title parameter changed
   */
  public UserMenuBuilder setPrompt(String prompt) {
    this.prompt = prompt;
    return this;
  }
  
  /**
   * Adds an option to the built {@link me.Kaleb.libs.UserMenu}
   *
   * @param option The option to add
   * @return The current builder with the supplied option added
   */
  public UserMenuBuilder addOption(String option) {
    this.options.add(option);
    return this;
  }
  
  /**
   * Adds multiple options to the built {@link me.Kaleb.libs.UserMenu}
   *
   * @param options The options to add
   * @return The current builder with the supplied option added
   */
  public UserMenuBuilder addAllOptions(String... options) {
    this.options.addAll(Arrays.asList(options));
    return this;
  }
  
  /**
   * Builds a {@link me.Kaleb.libs.UserMenu}.
   * This function uses the supplied values from {@link #setTitle}, {@link #setPrompt}, and either {@link #addOption} or {@link #addAllOptions} to build a {@link me.Kaleb.libs.UserMenu}.<br/>
   * Example:<br/>
   * <code>UserMenu myMenu = new UserMenuBuilder()<br/>
   *                         .setTitle("My Title")<br/>
   *                         .setDescription("My prompt here")<br/>
   *                         .addOption("This is an option")<br/>
   *                         .addAllOptions("These are also", "multiple options")<br/>
   *                         .build();</code>
   *
   * @return The current builder with the supplied option added
   */
  public UserMenu build() {
    return new UserMenu(title, prompt, options);
  }
}
