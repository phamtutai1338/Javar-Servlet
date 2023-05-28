package car_list;

public class Car {

        private int id;
        private String carName;
        private Double price;

        private  String color;
        private  String image;

        public Car(int id, String carName, Double price , String color, String image){
            super();
            this.id = id;
            this.carName = carName;
            this.price = price;
            this.color=color;
            this.image= image;
        }

        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getCarName(){
            return carName;
        }
        public void setCarName(String carName){

            this.carName = carName;
        }
        public Double getPrice(){

            return price;
        }
        public void setPrice(Double price){

            this.price = price;
        }

        public String getColor() {

            return color;
         }
         public void setColor(String color) {

            this.color = color;
         }
         public String getImage() {

            return image;
    }

         public void setImage(String image) {

            this.image = image;
    }
}

