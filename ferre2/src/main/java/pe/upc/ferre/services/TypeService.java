package pe.upc.ferre.services;

import java.util.List;

import pe.upc.ferre.entidades.Type;

public interface TypeService {
   public List<Type> listTypes();
   public Type register(Type type);
}
