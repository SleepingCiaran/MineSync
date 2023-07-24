package be.ciaran.minesync.internal.jedis.jedis.commands;

public interface PipelineBinaryCommands extends KeyPipelineBinaryCommands,
    StringPipelineBinaryCommands, ListPipelineBinaryCommands, HashPipelineBinaryCommands,
    SetPipelineBinaryCommands, SortedSetPipelineBinaryCommands, GeoPipelineBinaryCommands,
    HyperLogLogPipelineBinaryCommands, StreamPipelineBinaryCommands,
    ScriptingKeyPipelineBinaryCommands, SampleBinaryKeyedPipelineCommands, FunctionPipelineBinaryCommands {
}
