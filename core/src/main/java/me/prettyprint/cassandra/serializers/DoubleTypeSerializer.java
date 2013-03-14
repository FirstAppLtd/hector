package me.prettyprint.cassandra.serializers;

import static me.prettyprint.hector.api.ddl.ComparatorType.DOUBLETYPE;

import java.nio.ByteBuffer;

import me.prettyprint.hector.api.ddl.ComparatorType;

/**
 * Serialization class to use with Cassandras DoubleType.
 * 
 * @author Felix Obenauer
 */
public class DoubleTypeSerializer extends AbstractSerializer<Double> {

	private static final DoubleTypeSerializer instance = new DoubleTypeSerializer();

	public static DoubleTypeSerializer get() {
		return instance;

	}

	@Override
	public ByteBuffer toByteBuffer(Double obj) {
		if (obj == null) {
			return null;
		}
		byte[] bytes = new byte[8];
		ByteBuffer result = ByteBuffer.wrap(bytes).putDouble(obj);
		result.rewind();
		return result;
	}

	@Override
	public Double fromByteBuffer(ByteBuffer byteBuffer) {
		double result = byteBuffer.getDouble();
		return result;
	}

	@Override
	public ComparatorType getComparatorType() {
		return DOUBLETYPE;
	}
}
