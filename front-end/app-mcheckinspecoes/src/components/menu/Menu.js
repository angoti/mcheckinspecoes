import {
  DrawerContentScrollView,
  DrawerItem,
  DrawerItemList,
  createDrawerNavigator,
} from "@react-navigation/drawer";

import React from "react";
import { Alert, Text, View } from "react-native";
import Home from "../../components/home/Home";
import Ajuda from "../../components/menu/Ajuda";
import ListaInspecoes from "../../components/menu/ListaInspecoes";
import Perfil from "../../components/menu/Perfil";

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

function CustomDrawerContent(props) {
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
}

const Drawer = createDrawerNavigator();

const MyDrawer = () => {
  return (
    <Drawer.Navigator
      drawerContent={(props) => <CustomDrawerContent {...props} />}
    >
      <Drawer.Screen name="Início" component={Home} />
      <Drawer.Screen name="Perfil" component={Perfil} />
      <Drawer.Screen name="Lista Inspecões" component={ListaInspecoes} />
      <Drawer.Screen name="Ajuda" component={Ajuda} />
    </Drawer.Navigator>
  );
};

export default MyDrawer;
