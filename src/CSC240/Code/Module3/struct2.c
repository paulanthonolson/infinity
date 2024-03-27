void main() {
   struct position {
      float latitude;
      float longitude;
   };

   struct position p;
   p.latitude = 33.480692;    // Estrella Hall
   p.longitude = -112.343227;

   struct position *x = &p;
   (*x).latitude = 0.0;

   x->latitude = 33.4812454;   // OCT117
   x->longitude = -112.3456496;
}
