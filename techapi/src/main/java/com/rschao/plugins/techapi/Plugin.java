package com.rschao.plugins.techapi;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * techapi java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("techapi");

  public void onEnable()
  {
    LOGGER.info("techapi enabled");
  }

  public void onDisable()
  {
    LOGGER.info("techapi disabled");
  }
}
