package concurrency.in.practice.lock;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {

	private final Map<K, V> map;
	private final ReentrantReadWriteLock readWriteLock;
	private final ReadLock readLock;
	private WriteLock writeLock;

	/**
	 * @param map
	 */
	public Cache(Map<K, V> map) {
		super();
		this.map = map;
		readWriteLock = new ReentrantReadWriteLock();
		readLock = readWriteLock.readLock();
		writeLock = readWriteLock.writeLock();
	}

	/**
	 * @return the writeLock
	 */
	public WriteLock getWriteLock() {
		return writeLock;
	}

	public V put(K key, V value) {
		try {
			writeLock.lock();
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	public V get(K key) {
		try {
			readLock.lock();
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

	/**
	 * @param writeLock
	 *            the writeLock to set
	 */
	public void setWriteLock(WriteLock writeLock) {
		this.writeLock = writeLock;
	}

	/**
	 * @return the map
	 */
	public Map<K, V> getMap() {
		return map;
	}

	/**
	 * @return the readLock
	 */
	public ReadLock getReadLock() {
		return readLock;
	}

}
