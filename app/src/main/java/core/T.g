grammar T;

@header {
import java.util.ArrayList;
import java.util.List;
}

@members{   
       @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e){
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e,tokenNames);
      System.err.println(">> My compiler >>"+hdr + " " + msg );

    }
   
   List <Tabla> tablas = new ArrayList<Tabla>();  
             Tabla tablaActual = null;
}

inicio :  creacion usar tabla+ cerrar;

creacion : CREAR ID {System.out.println("CREATE DATABASE "+$ID.text+";"); 
                    }; 

usar     : USAR  ID {System.out.println("USE  "+$ID.text+";"); };


// tabla : TABLA ID INICIO {} campo+ FIN {};


tabla    : TABLA ID INICIO 
                  { 
                    //código para generar SQL
      System.out.println("CREATE TABLE "+$ID.text ); 
      System.out.println(" ("+$ID.text+"_key INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL"); 
                     //código para crear estructura de datos
                        Tabla t = new Tabla();
                        t.nombre =$ID.text;
                        tablas.add(t);
                        tablaActual = t;
                     //
                   }
             campo+ 
             FIN  {
                     System.out.println("   );   "); 
                  };

campo   : ID (t=NUMERICO | t=ALFABETICO | t=FECHA)
          { //aquí hay que agregar código para generar SQL
                    if(($t.text).compareTo("letras")==0) 
                       System.out.println(", "+$ID.text + " VARCHAR(300)" );
                    else if(($t.text).compareTo("fecha")==0)
                       System.out.println(", "+$ID.text + " DATE" ); 
                    else if(($t.text).compareTo("numeros")==0)
                       System.out.println(", "+$ID.text + " INT"  );    

                 //el que sigue es código para crear estructura de datos
                  Atributo a  = new Atributo();
                      a.nombreAtributo = $ID.text;
                      a.tipoAtributo = $t.text;
                  tablaActual.atributos.add(a);
          }
        | t=DEPENDE ID 
          {
                  boolean tablaEncontrada = false;
                  for(int i=0; i<tablas.size(); i++) {
                     if(tablas.get(i).nombre.equals($ID.text)) {
                        tablaEncontrada = true;
                        // Aquí puedes agregar la lógica para manejar la llave foránea
                        System.out.print(", "+$ID.text + "_id INT");
                        System.out.println(", FOREIGN KEY ("+$ID.text + "_id)  REFERENCES " + $ID.text + "(" + $ID.text + "_key) ON DELETE CASCADE");
                          Atributo a  = new Atributo();
                           a.nombreAtributo = $ID.text;
                           a.tipoAtributo = $t.text;
                           tablaActual.atributos.add(a);
                        break;
                     }
                  }
                  if(!tablaEncontrada) {
                     System.err.println("Error: La tabla '" + $ID.text + "' no existe.");
                  }
          }
        ;


cerrar   : CERRAR {
              /*for (int i=0; i<tablas.size(); i++){ 
                 System.out.println("\nTabla: "+tablas.get(i).nombre);
                 List <Atributo> atribs= tablas.get(i).atributos;
                 for (int j=0; j<atribs.size(); j++){  
                   System.out.print("<Atributo>  "+atribs.get(j).nombreAtributo);
                   System.out.println(" \t<TipoAtrib> "+atribs.get(j).tipoAtributo);
                 }
             }*/

           };

CERRAR   : 'cerrar';
NUMERICO  : 'numeros';
ALFABETICO: 'letras';
FECHA     : 'fecha'  ;
TABLA : 'tabla'  ;
INICIO: 'inicio' ;
FIN   : 'fin'    ;
USAR  : 'usar'   ;
CREAR : 'crear'  ;
DEPENDE : 'depende_de';
ID    : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;  
WS   :(' ' | '\n' | '\t' | '\r')+   {$channel=HIDDEN; } ;

