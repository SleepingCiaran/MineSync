package be.ciaran.minesync.internal.jedis.jedis.commands;

public interface JedisBinaryCommands extends KeyBinaryCommands, StringBinaryCommands,
    ListBinaryCommands, HashBinaryCommands, SetBinaryCommands, SortedSetBinaryCommands,
    GeoBinaryCommands, HyperLogLogBinaryCommands, StreamBinaryCommands, ScriptingKeyBinaryCommands,
    FunctionBinaryCommands {
}
