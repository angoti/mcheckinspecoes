import React from "react";
import { DrawerContentScrollView, DrawerItemList, DrawerItem } from "@react-navigation/drawer";
import { Alert, Text, View } from "react-native";

const DrawerMenu = (props) => {
  const handleLogout = () => {
    Alert.alert("Sair", "Tem certeza que deseja sair?", [
      {
        text: "Cancelar",
        style: "cancel",
      },
      {
        text: "Sair",
        onPress: () => {
          console.log("Logout realizado com sucesso!");
        },
        style: "destructive",
      },
    ]);
  };

  return (
    <DrawerContentScrollView {...props}>
      <View style={{ paddingHorizontal: 16, paddingTop: 32 }}>
        <Text style={{ fontSize: 20, fontWeight: "bold", marginBottom: 16 }}>
          Mcheck Inspeções
        </Text>
      </View>
      <DrawerItemList {...props} />
      <DrawerItem
        label="Sair"
        onPress={handleLogout}
        style={{ borderTopWidth: 1, borderTopColor: "#ccc" }}
      />
    </DrawerContentScrollView>
  );
};

export default DrawerMenu;
