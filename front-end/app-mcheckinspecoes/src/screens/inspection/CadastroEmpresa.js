import React from "react";
import { Text, TextInput, View, Button, TouchableOpacity } from "react-native";
import { createDrawerNavigator } from "@react-navigation/drawer";
import { NavigationContainer } from "@react-navigation/native";

const EnterpriseScreen = ({ navigation }) => {
  return (
    <View>
      <TouchableOpacity
        onPress={() => navigation.dispatch(DrawerActions.openDrawer())}
      >
        <Text>Menu</Text>
      </TouchableOpacity>
      <Text style={{}}>Nome da empresa</Text>
      <TextInput defaultValue="Ex.: Wagner Magri Consultoria" />
      <Text>Nome do inspetor</Text>
      <TextInput defaultValue="Ex.: Wagner Magri" />
      <Text>Telefone do inspetor</Text>
      <TextInput defaultValue="Ex.: 99999999999" />
      <Text>Email do inspetor</Text>
      <TextInput defaultValue="Ex.: wagner.magri@gmail.com" />
      <Button onPress={() => {}} title={"Voltar"} />
      <Button onPress={() => {}} title={"Avançar"} />
    </View>
  );
};



export default Enterprise;
