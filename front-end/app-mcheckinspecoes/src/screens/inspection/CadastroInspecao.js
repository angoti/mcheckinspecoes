import React, { useState } from "react";
import { Text, TextInput, View, TouchableOpacity, StyleSheet } from "react-native";
import { SafeAreaProvider } from 'react-native-safe-area-context';
import MaterialIcons from "react-native-vector-icons/MaterialIcons";

const CustomCheckBox = ({ label, checked, onChange }) => {
    const handleToggle = () => {
        onChange(!checked);
    };

    return (
        <TouchableOpacity style={styles.checkboxContainer} onPress={handleToggle}>
            <MaterialIcons
                name={checked ? "check-box" : "check-box-outline-blank"}
                size={24}
                style={styles.checkboxIcon}
            />
            <Text>{label}</Text>
        </TouchableOpacity>
    );
};

const InspectionScreen = ({ navigation }) => {
    const [item, setItem] = useState("Ex.: Painel solar");
    const [observacao, setObservacao] = useState("Ex.: Painel desconfigurado");
    const [conforme, setConforme] = useState(false);
    const [naoConforme, setNaoConforme] = useState(false);
    const [naoSeAplica, setNaoSeAplica] = useState(false);

    const clearDefaultValue = (stateFunction, defaultValue) => {
        if (stateFunction() === "") {
            stateFunction(defaultValue);
        }
    };

    const handleAddItem = () => {
        // Lógica para adicionar item
    };

    const handleCameraPress = () => {
        // Lógica para tirar a foto
    };

    return (
        <SafeAreaProvider style={styles.container}>
            <View style={styles.contentContainer}>
                <Text style={styles.heading}>Itens Inspecionados</Text>
                <View style={styles.inputContainer}>
                    <Text>Item inspecionado</Text>
                    <TextInput
                        style={styles.textInput}
                        value={item}
                        onFocus={() =>
                            clearDefaultValue(setItem, "Ex.: Wagner Magri Consultoria")
                          }
                          onBlur={() =>
                            clearDefaultValue(setItem, "Ex.: Wagner Magri Consultoria")
                          }
                          onChangeText={(text) => setItem(text)}
                    />
                </View>
                <View style={styles.inputContainer}>
                    <Text>Observação</Text>
                    <TextInput
                        style={styles.textInput}
                        value={observacao}
                        onFocus={() =>
                            clearDefaultValue(setObservacao, "Ex.: Wagner Magri Consultoria")
                          }
                          onBlur={() =>
                            clearDefaultValue(setObservacao, "Ex.: Wagner Magri Consultoria")
                          }
                          onChangeText={(text) => setItem(text)}
                    />
                </View>
                <View style={styles.checkboxContainer}>
                    <View style={styles.cameraContainer}>
                        <TouchableOpacity onPress={handleCameraPress}>
                            <MaterialIcons name="photo-camera" size={24} style={styles.cameraIcon} />
                        </TouchableOpacity>
                    </View>
                    <View style={styles.checkboxContent}>
                        <CustomCheckBox
                            label="Item conforme"
                            checked={conforme}
                            onChange={(value) => setConforme(value)}
                        />
                        <CustomCheckBox
                            label="Item não conforme"
                            checked={naoConforme}
                            onChange={(value) => setNaoConforme(value)}
                        />
                        <CustomCheckBox
                            label="Item não se aplica"
                            checked={naoSeAplica}
                            onChange={(value) => setNaoSeAplica(value)}
                        />
                    </View>
                </View>
                <TouchableOpacity
                    onPress={handleAddItem}
                    style={styles.buttonAddItem}
                >
                    <View style={styles.buttonTextAddItem}>
                        <Text>Adicionar novo item</Text>
                        <MaterialIcons name="add-circle" size={24} style={styles.addItem} />
                    </View>
                </TouchableOpacity>
                <Text style={styles.passo}>Passo 2 de 3</Text>
                <View style={styles.buttonContainer}>
                    <TouchableOpacity
                        style={styles.button}
                        onPress={() => navigation.goBack()}
                    >
                        <Text style={styles.buttonText}>Voltar</Text>
                    </TouchableOpacity>
                    <TouchableOpacity
                        style={styles.button}
                        onPress={() => navigation.navigate("NextScreen")}
                    >
                        <Text style={styles.buttonText}>Avançar</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </SafeAreaProvider>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        paddingHorizontal: 20,
    },
    contentContainer: {
        marginBottom: 20,
        borderColor: "gray",
        borderRadius: 5,
    },
    heading: {
    fontSize: 24,
        fontWeight: "bold",
        margin: 40,
        textAlign: "center",
        justifyContent: "center",
        color: "#3cb371",
        fontWeight: "700"
    },
    inputContainer: {
        marginBottom: 20,
        borderWidth: 1,
        borderColor: "gray",
        borderRadius: 5,
        paddingHorizontal: 10,
    },
    checkboxContainer: {
        flexDirection: "row",
        alignItems: "center",
        marginBottom: 20,
    },
    cameraContainer: {
        marginRight: 20,
        borderWidth: 1,
        borderColor: "gray",
        borderRadius: 8
    },
    cameraIcon: {
        color: "black",
        padding: 50,
        margin: 20,
    },
    checkboxContent: {
        flex: 1,
    },
    checkboxContainer: {
        flexDirection: "row",
        alignItems: "center",
    },
    checkboxIcon: {
        marginRight: 8,
    },
    button: {
        backgroundColor: "#3cb371",
        paddingVertical: 15,
        paddingHorizontal: 20,
        marginHorizontal: 10,
        height: 50,
        width: 150,
        borderRadius: 10,
        justifyContent: "center",
        alignItems: "center",
    },
    buttonText: {
        color: "white",
        textAlign: "center",
        fontSize: 18,
    },
    buttonAddItem: {
        backgroundColor: "transparent",
        height: 50,
        width: 180,
        borderRadius: 10,
        borderWidth: 1,
        marginTop: 30,
        marginHorizontal: 85,
        borderColor: "gray",
        borderRadius: 8
    },
    buttonTextAddItem: {
        color: "black",
        alignItems: "center",
        justifyContent: "center",
        flexDirection: "row", // Adicionado flexDirection
    },
    addItem: {
        margin: 10,
        marginLeft: 5, // Adicionado marginLeft para espaçamento
    },
    passo: {
        color: "#3cb371",
        fontWeight: "700",
        textAlign: "right",
        marginVertical: 30,
    },
    buttonContainer: {
        flexDirection: "row",
        justifyContent: "center",
        marginBottom: 20,
    },
});

export default InspectionScreen;
