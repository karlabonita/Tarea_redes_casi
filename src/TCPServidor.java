import java.io.*; 
import java.net.*; 
import java.util.ArrayList;
import java.util.Iterator;

class TCPServidor { 
    public static ArrayList<Usuario> clientes = new ArrayList<Usuario>();

    
    
    public static boolean estaRegistrado(String nombre){
    Usuario posicion; 
    Iterator<Usuario> iter = clientes.iterator();
    while(iter.hasNext()){
        posicion = iter.next();
       if(posicion.nombre.equals(nombre)){
           System.out.println("Error, usuario ya registrado");
           return true;
    }
        
       
        }
     return false;
   }
    
    public static boolean registro(String nombre, String password){
    Usuario posicion;
    Iterator<Usuario> iterador = clientes.iterator();
    while(iterador.hasNext()){
        posicion = iterador.next();
        if(posicion.nombre.equals(nombre)&& posicion.password.equals(password)){
            System.out.println("Bienvenido usuario" + nombre);
            return true;
        }   
     }
      System.out.println("caca");
     return false;
    }
    
    
  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence, nombre ="", password =""; 
      int po=0;
      clientes.add(new Usuario("karla","kola123"));
      ServerSocket welcomeSocket = new ServerSocket(9875); 
  
      while(true) { 
  
           Socket connectionSocket = welcomeSocket.accept(); 

           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
       
	   PrintWriter outToClient =  new PrintWriter(connectionSocket.getOutputStream(), true); 
           
           System.out.println("Hola, Bienvenido\n\n"
                   + "Si es usuario ya registrado,  presione 1\n"
                   + "Si quiere crear un nuevo usuario, presione 2\n");
           connectionSocket.getInetAddress();
           outToClient.println(po);
 
           switch(po){
               case 1:
                     clientSentence = inFromClient.readLine(); 
                     nombre = clientSentence;
                     clientSentence = inFromClient.readLine();
                     password = clientSentence;
                     outToClient.println(nombre);
                     outToClient.println(password);
           
                     if(estaRegistrado(nombre)){
              
                    }else if(registro(nombre,password)){
           
           
                    }  
                     break;
                     
                     
               default:
                   System.out.println("");
                   break;
           }
           
           
           
          
           //System.out.println(connectionSocket.getInetAddress()+" message:"+clientSentence);
           
          // outToClient.println(clientSentence); //envia al cliente
        }
     // si se usa una condicion para quebrar el ciclo while, se deben cerrar los sockets!
     //connectionSocket.close(); 
     // welcomeSocket.close(); 
    } 
} 
 
