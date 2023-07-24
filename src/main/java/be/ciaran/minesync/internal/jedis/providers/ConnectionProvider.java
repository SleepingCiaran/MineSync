package be.ciaran.minesync.internal.jedis.jedis.providers;

import be.ciaran.minesync.internal.jedis.CommandArguments;
import be.ciaran.minesync.internal.jedis.Connection;

public interface ConnectionProvider extends AutoCloseable {

  Connection getConnection();

  Connection getConnection(CommandArguments args);
}
