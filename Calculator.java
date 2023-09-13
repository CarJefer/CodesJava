import java.util.Scanner;
//Denominei a classe Calculator e adicionei os atributos da classe;
class Calculator{
    int battery;
    int batteryMax;
    float display;
    //Inicia os atributos batteryMax utilizando o parametro passado
    Calculator(int batteryMax){
        this.battery = 0;
        this.batteryMax = batteryMax;
        this.display = 0.0f;
    }

  //Método para recarregar a batéria;
    void chargeBattery(int value){
        if(value < 0){
            return;
        }
        this.battery += value;
        if(this.battery > this.batteryMax){
            this.battery = batteryMax;
        }
        
    }
    //Método para utilizar bateria toda vez que realizar alguma ação na calculadora;
    boolean useBattery(){
        if(this.battery == 0){
            System.out.println("fail: bateria insuficiente");
            return false;
        }
        this.battery -= 1;
            return true;
    }
    //Método de soma;
    void sum(int a, int b){
        if(useBattery() ){
            this.display = a + b;
        }
    }
    //Método de divisão;
    void division(int num, int den){
        if(!useBattery())
            return;
        
        if(den == 0){
            System.out.println("fail: divisao por zero");
        }
        else {
            this.display = (float) num / den;
        }
    }
    //Método para mostrar na tela;
    void show(){
        System.out.printf("display = %.2f, battery = %d%n", this.display, this.battery);
    }
    
}

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Calculator calc = null;
        
        
        while (true) { // Loop infinito
            var line = scan.nextLine();
            System.out.println("$" + line);
            var arg = line.split(" ");

            if (arg[0].equals("end")) {  break; }// Sai do loop infinito quando "end" é digitado 
            else if(arg[0].equals("init")){ calc = new Calculator(Integer.parseInt(arg[1])); }
            else if (arg[0].equals("show")) { calc.show(); } 
            else if (arg[0].equals("charge")) { calc.chargeBattery(Integer.parseInt(arg[1])); }
            else if (arg[0].equals("sum")) { calc.sum(Integer.parseInt(arg[1]), Integer.parseInt(arg[2])); }
            else if (arg[0].equals("div")) { calc.division(Integer.parseInt(arg[1]), Integer.parseInt(arg[2])); }
            else { System.out.println("fail: comando invalido"); }
        }
        
    }
}
