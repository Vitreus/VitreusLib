package com.vitreusmc.lib.database;

import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MapperOptions;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class DatastoreFactory {

	public static Datastore create(String host, int port, String user, String userDb, String password, String databaseName) {
		ServerAddress address = new ServerAddress(host, port);
		List<MongoCredential> credentials = Arrays.asList(MongoCredential.createCredential(user, userDb, password.toCharArray()));
		MongoClient mongo = new MongoClient(address, credentials);
		Morphia morphia = new Morphia();
		MapperOptions options = morphia.getMapper().getOptions();
		Datastore datastore;
		
		options.setStoreEmpties(true);
		morphia.mapPackage("com.vitreusmc.lib.database.entities");
		datastore = morphia.createDatastore(mongo, databaseName);
		datastore.ensureIndexes();
		
		return datastore;
	}
	
	public static Datastore create(FileConfiguration config) {		
		int port = config.getInt("db.port");
		String host = config.getString("db.host");
		String user = config.getString("db.user.name");
		String userDb = config.getString("db.user.authDBName");
		String password = config.getString("db.user.password");
		String databaseName = config.getString("db.name");
		
		return create(host, port, user, userDb, password, databaseName);
	}
	
}
