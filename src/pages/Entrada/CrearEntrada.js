import TempActivos from '../../components/TempActivos/TempActivosContainer';
import TempConsumibles from '../../components/TempConsumibles/TempConsumiblesContainer';
import { Container, Row, Col, Card, Button, Form, Spinner } from 'react-bootstrap';
import { Fragment } from 'react';
import InputText from '../../components/InputText';
import Select from '../../components/Select';
import Datepicker from '../../components/Datepicker';
import TextArea from '../../components/TextArea';
import Autocomplete from '../../components/Autocomplete';

function CrearEntrada(props) {

    const { 
        fecha,
        valor,
        guia,
        proveedor,
        ordenCompra,
        documento,
        nota,
        activos,
        onChangeActivos,
        searchActivos,
        consumibles,
        onChangeConsumibles,
        searchConsumibles,
        proveedores,
        ordenesCompra,
        onChange,
        onSubmit
    } = props;

    return (
        <Fragment>
            <Card style={{ width: '100%' }}>
              <Card.Body>
                <Card.Title>
                    <h4>Registrar Entrada</h4>
                </Card.Title>
                <br/>
                <Form onSubmit={onSubmit}>
                    <Row>
                        <Col>
                            <Datepicker
                                name="fecha"
                                label="Fecha"
                                value={fecha}
                                info="Por favor indique la fecha."
                                onChange={onChange}
                            />
                            <Autocomplete
                                name="proveedor"
                                placeholder="Proveedor..."
                                info="Por favor encuentre el proveedor."
                                onChange={onChange}
                                options={proveedores}
                                labelKey="id"
                            />
                        </Col>
                        <Col>
                            <InputText
                                name="valor"
                                placeholder="Valor"
                                value={valor}
                                info="Por favor ingrese el valor de la gu??a."
                                onChange={onChange}
                            />
                            <Select 
                                name="ordenCompra"
                                label="Orden de Compra"
                                value={ordenCompra}
                                info="Por favor seleccione la orden de compra."
                                onChange={onChange}
                                options={ordenesCompra}
                            />
                        </Col>
                        <Col>
                            <InputText
                                name="guia"
                                placeholder="N?? Gu??a"
                                value={guia}
                                info="Por favor ingrese el n??mero de la gu??a."
                                onChange={onChange}
                            />
                            <InputText
                                name="documento"
                                placeholder="Archivo"
                                value={documento}
                                info="Por favor ingrese el n??mero de la gu??a."
                                onChange={onChange}
                            />
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <TextArea
                                name="nota"
                                label="Nota"
                                value={nota}
                                info="Aqu?? puede escribir una nota."
                                onChange={onChange}
                                rows="2"
                            />
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <TempActivos 
                                activos={activos} 
                                onChangeActivos={onChangeActivos} 
                                searchList={searchActivos} 
                            />
                        </Col>
                        <Col>
                            <TempConsumibles 
                                consumibles={consumibles} 
                                onChangeConsumibles={onChangeConsumibles} 
                                searchList={searchConsumibles} 
                            />
                        </Col>
                    </Row>
                    <br/>
                    <Row>
                        <Col>
                            <Button type="submit" variant="outline-dark" size="lg" block>Guardar</Button>
                        </Col>
                        <Col>
                            <Button href="/" variant="outline-dark" size="lg" block>Cancelar</Button>
                        </Col>
                    </Row>
                </Form>
              </Card.Body>
            </Card>
        </Fragment>
    );

}

export default CrearEntrada;