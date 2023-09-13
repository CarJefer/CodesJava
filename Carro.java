import java.util.Scanner;

//Denominei a classe Carro e adicionei os atributos;
class Carro {
    int pass; 
    int passMax; 
    int gas;
    int gasMax;
    int km;
    
    Carro() {
        this.passMax = 2;
        this.gasMax = 100;
    }
    Carro(int passMax, int gasMax) {
        this.passMax = passMax;
        this.gasMax = gasMax;
    }
    
    //Denominei o método "enter" para realizar a entrada de passageiros no carro;
    void enter() {
        if( this.pass < this.passMax ){
            this.pass++;
        } else {
            System.out.println("fail: limite de pessoas atingido");
        }
    }
    //Denominei o método "leave" para realizar a saída passageiros;
    void leave() {
        if( this.pass <= 0) {
            System.out.println("fail: nao ha ninguem no carro");
        } else {
            this.pass--;
        }
    }
    //Denominei o método "fuel" para abastecer o carro;
    void fuel( int comb ) {
        this.gas += comb;
        if( this.gas > this.gasMax ){
            this.gas = this.gasMax;
        }
    }
    //Denominei o método "drive" para dirigir o carro;
    void drive(int km) {
        if( this.pass == 0 ) {
             System.out.println("fail: nao ha ninguem no carro");
        } else if ( this.gas == 0 ) {
            System.out.println("fail: tanque vazio");
        } else if ( this.gas < km) {
            System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
            this.km += this.gas;
            this.gas = 0;
        } else {
            this.km += km;
            this.gas -= km;
        }
    }
    void show(){
        System.out.println( "pass: " + this.pass + ", " + "gas: " + this.gas + ", " + "km: " + this.km);
    }
    
}

public class Main {
    public static void main(String[] a) {
        Carro car = new Carro();
        
        while (true) {
            
            //var é utilizado quando você não quer declarar o tipo da variável e o computador declara pra você; Ex: var number = 1 / int number = 1;
            var line = input();
            write("$" + line);
            var args = line.split(" ");
            
            //".equals()" é utilizado para verificar strings se são iguais ou não; Ex: string args{"jeferson"}; args.equals("jeferson") { return true };
            if      (args[0].equals("end"))   { break;                                }
            else if (args[0].equals("show"))  { car.show(); } //System.out.println(car);              }
            else if (args[0].equals("enter")) { car.enter();                          }
            else if (args[0].equals("leave")) { car.leave();                          }
            else if (args[0].equals("drive")) { car.drive((int) number(args[1]));     }
            else if (args[0].equals("fuel"))  { car.fuel((int) number(args[1]));      }
            else                              { write("fail: comando invalido");}
        }
    }

     static Scanner scanner = new Scanner(System.in);
     static String  input()              { return scanner.nextLine(); }
     static double  number(String value) { return Double.parseDouble(value); }
     static void    write(String value)  { System.out.println(value); }
}
