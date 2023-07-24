package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;
import java.util.Map;

import be.ciaran.minesync.internal.jedis.GeoCoordinate;
import be.ciaran.minesync.internal.jedis.Response;
import be.ciaran.minesync.internal.jedis.args.GeoUnit;
import be.ciaran.minesync.internal.jedis.params.GeoAddParams;
import be.ciaran.minesync.internal.jedis.params.GeoRadiusParam;
import be.ciaran.minesync.internal.jedis.params.GeoRadiusStoreParam;
import be.ciaran.minesync.internal.jedis.params.GeoSearchParam;
import be.ciaran.minesync.internal.jedis.resps.GeoRadiusResponse;

public interface GeoPipelineCommands {

  Response<Long> geoadd(String key, double longitude, double latitude, String member);

  Response<Long> geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap);

  Response<Long> geoadd(String key, GeoAddParams params, Map<String, GeoCoordinate> memberCoordinateMap);

  Response<Double> geodist(String key, String member1, String member2);

  Response<Double> geodist(String key, String member1, String member2, GeoUnit unit);

  Response<List<String>> geohash(String key, String... members);

  Response<List<GeoCoordinate>> geopos(String key, String... members);

  Response<List<GeoRadiusResponse>> georadius(String key, double longitude, double latitude, double radius,
      GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadiusReadonly(String key, double longitude, double latitude,
      double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadius(String key, double longitude, double latitude, double radius,
      GeoUnit unit, GeoRadiusParam param);

  Response<List<GeoRadiusResponse>> georadiusReadonly(String key, double longitude, double latitude,
      double radius, GeoUnit unit, GeoRadiusParam param);

  Response<List<GeoRadiusResponse>> georadiusByMember(String key, String member, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String key, String member, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadiusByMember(String key, String member, double radius, GeoUnit unit,
      GeoRadiusParam param);

  Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String key, String member, double radius,
      GeoUnit unit, GeoRadiusParam param);

  Response<Long> georadiusStore(String key, double longitude, double latitude, double radius, GeoUnit unit,
      GeoRadiusParam param, GeoRadiusStoreParam storeParam);

  Response<Long> georadiusByMemberStore(String key, String member, double radius, GeoUnit unit,
      GeoRadiusParam param, GeoRadiusStoreParam storeParam);

  Response<List<GeoRadiusResponse>> geosearch(String key, String member, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, GeoCoordinate coord, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, String member, double width, double height, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, GeoCoordinate coord, double width, double height, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, GeoSearchParam params);

  Response<Long> geosearchStore(String dest, String src, String member, double radius, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, GeoCoordinate coord, double radius, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, String member, double width, double height, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, GeoCoordinate coord, double width, double height, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, GeoSearchParam params);

  Response<Long> geosearchStoreStoreDist(String dest, String src, GeoSearchParam params);
}
