package me.prettyprint.cassandra.serializers;

import static me.prettyprint.hector.api.ddl.ComparatorType.DOUBLETYPE;

import java.nio.ByteBuffer;

import me.prettyprint.hector.api.ddl.ComparatorType;

/**
 * Uses LongSerializer via translating Doubles to and from raw long bytes form.
 * 
 * @author Yuri Finkelstein 
 */
public class DoubleSerializer extends AbstractSerializer<Double> {

	private static final DoubleSerializer instance = new DoubleSerializer();

	public static DoubleSerializer get() {
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
