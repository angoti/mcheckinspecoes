import React from "react";
import { View, Text, Image, StyleSheet, TouchableOpacity } from "react-native";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";
import CadastroEmpresa from "../../screens/inspection/CadastroEmpresa";
import CadastroInspecao from "../../screens/inspection/CadastroInspecao";
import AssinaturaInspecao from "../../screens/inspection/AssinaturaInspecao";
import VisualizarPdf from "../../screens/inspection/VisualizarPdf";

const Stack = createStackNavigator();

export const Inicio = ({ navigation }) => {
  return (
    <View style={styles.container}>
        {/* <Text style={styles.title}>MCheck</Text>
        <Text style={styles.subtitle}>Inspeções</Text> */}
        <Image
              source={require("../../../assets/logo.png")}
              style={styles.logo}
            />
        <View style={styles.center}>
          <TouchableOpacity onPress={() => navigation.navigate('CadastroEmpresa')}>
            <Image
              source={require("../../../assets/btn-adicionar.png")}
              style={styles.button}
            />
          </TouchableOpacity>
          <Text style={styles.text}>Criar Inspeção</Text>
        </View>
    </View>
  );
};

export const Home = () => {
  return (
    <NavigationContainer independent='true'>
      <Stack.Navigator>
        <Stack.Screen name="Inicio" component={Inicio} options={{headerShown:false}}/>
        <Stack.Screen name="CadastroEmpresa" component={CadastroEmpresa} options={{ headerShown: false }}/>
        <Stack.Screen name="CadastroInspecao" component={CadastroInspecao} options={{ headerShown: false }}/>
        <Stack.Screen name="AssinaturaInspecao" component={AssinaturaInspecao} options={{ headerShown: false }}/>
        {/* <Stack.Screen name="VisualizarPdf" component={VisualizarPdf} options={{ headerShown: false }}/> */}
      </Stack.Navigator>
    </NavigationContainer>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    alignItems: 'center',
  },
  center: {
    alignItems: 'center',
    flex: 1,
    justifyContent: 'center'
  },
  logo: {
  },
  // title: {
  //   color: 'black',
  //   fontWeight: 'bold',
  //   fontSize: 30,
  //   textAlign: 'center',
  // },
  // subtitle: {
  //   color: 'black',
  //   fontWeight: '600',
  //   fontSize: 20,
  //   textAlign: 'center',
  // },
  text: {
    color: '#3CB371',
    fontWeight: 'bold',
    fontSize: 20,
    padding: 10,
  },
  button: {
    margin: 15,
    width: 80,
    height: 80
  }
});
