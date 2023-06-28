import React from "react";
import { View, Button, Alert } from "react-native";

const SairDoApp = () => {
  const handleLogout = () => {
    Alert.alert(
      "Sair",
      "Tem certeza que deseja sair?",
      [
        {
          text: "Cancelar",
          style: "cancel"
        },
        {
          text: "Sair",
          onPress: () => {
            // Lógica para realizar o logout
            console.log("Logout realizado com sucesso!");
          },
          style: "destructive"
        }
      ]
    );
  };

  return (
    <View>
      <Button title="Sair" onPress={handleLogout} />
    </View>
  );
};

export default SairDoApp;
