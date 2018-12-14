let generateConfig = (ip, port) => {
  ip, port;
};

export class HTTP_Config {
  static SERVER_IP = "119.29.34.133";

  static SERVER_CONFIG = generateConfig(SERVER_IP, "80");
  static MASTER_DATABASE = generateConfig(SERVER_IP, "3306");
  static CACHE_DATABASE = generateConfig(SERVER_IP, "6379");
}
