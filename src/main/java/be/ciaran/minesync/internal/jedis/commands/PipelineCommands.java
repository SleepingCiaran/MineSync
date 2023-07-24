package be.ciaran.minesync.internal.jedis.jedis.commands;

public interface PipelineCommands extends KeyPipelineCommands, StringPipelineCommands,
    ListPipelineCommands, HashPipelineCommands, SetPipelineCommands, SortedSetPipelineCommands,
    GeoPipelineCommands, HyperLogLogPipelineCommands, StreamPipelineCommands,
    ScriptingKeyPipelineCommands, SampleKeyedPipelineCommands, FunctionPipelineCommands {
}
