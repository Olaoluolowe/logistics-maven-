package africa.semicolon.data.repositories;

import africa.semicolon.data.models.Package;

import java.util.*;

public class PackageRepositoryImpl implements PackageRepository {

    private final Map<Integer, Package> database = new HashMap<>();

    @Override
    public Package save(Package aPackage) {
        Integer id = null;
        if ( aPackage.getTrackingId() == null ){
            id = database.size()+1;
            aPackage.setTrackingId(id);
        }
        id = aPackage.getTrackingId();
        database.put(id, aPackage);
        return database.get(id);
    }

    @Override
    public List<Package> findAll() {
        List<Package> all = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys){
            all.add(database.get(key));

        }
        return all;
    }

    @Override
    public void delete(Package aPackage) {
        database.remove(aPackage.getTrackingId());
    }

    @Override
    public void deleteByTrackingNumber(Integer trackingId) {
        database.remove(trackingId);
    }

    @Override
    public void deleteAll() {
        database.clear();
    }

    @Override
    public Package findPackageByTrackingNumber(Integer trackingId) {
        return database.get(trackingId);
    }
}
